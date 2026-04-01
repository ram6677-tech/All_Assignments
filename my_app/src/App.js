import React, { createContext, useContext, useReducer } from "react";
import styled, { ThemeProvider } from "styled-components";

const AppContext = createContext();

const initialState = {
  count: 0,
  theme: "light",
  notifications: []
};

function reducer(state, action) {
  switch (action.type) {
    case "INCREMENT":
      return { ...state, count: state.count + 1 };
    case "DECREMENT":
      return { ...state, count: state.count - 1 };
    case "TOGGLE_THEME":
      return { ...state, theme: state.theme === "light" ? "dark" : "light" };
    case "ADD_NOTIFICATION":
      return {
        ...state,
        notifications: [...state.notifications, action.payload]
      };
    default:
      return state;
  }
}

export const AppProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  return (
    <AppContext.Provider value={{ state, dispatch }}>
      {children}
    </AppContext.Provider>
  );
};

export const useAppContext = () => useContext(AppContext);

const lightTheme = {
  bg: "#f5f5f5",
  text: "#222",
  card: "#fff"
};

const darkTheme = {
  bg: "#1e1e1e",
  text: "#fff",
  card: "#2c2c2c"
};

const Container = styled.div`
  background: ${(props) => props.theme.bg};
  color: ${(props) => props.theme.text};
  min-height: 100vh;
  padding: 20px;
  transition: all 0.3s ease;
`;

const Card = styled.div`
  background: ${(props) => props.theme.card};
  padding: 20px;
  margin: 10px 0;
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.2);
`;

const Button = styled.button`
  padding: 10px 15px;
  margin: 5px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  background: ${(props) => (props.primary ? "#4CAF50" : "#2196F3")};
  color: white;

  &:hover {
    transform: scale(1.05);
  }
`;

const Notification = styled.div`
  padding: 10px;
  margin: 5px 0;
  border-left: 5px solid #ff9800;
  background: ${(props) => props.theme.card};
`;

const Counter = () => {
  const { state, dispatch } = useAppContext();

  return (
    <Card>
      <h2>Counter</h2>
      <p>Value: {state.count}</p>
      <Button onClick={() => dispatch({ type: "INCREMENT" })}>+</Button>
      <Button onClick={() => dispatch({ type: "DECREMENT" })}>-</Button>
    </Card>
  );
};

const ThemeToggle = () => {
  const { dispatch } = useAppContext();

  return (
    <Card>
      <h2>Theme Switcher</h2>
      <Button primary onClick={() => dispatch({ type: "TOGGLE_THEME" })}>
        Toggle Theme
      </Button>
    </Card>
  );
};

const NotificationPanel = () => {
  const { state, dispatch } = useAppContext();

  return (
    <Card>
      <h2>Notifications</h2>
      <Button
        onClick={() =>
          dispatch({
            type: "ADD_NOTIFICATION",
            payload: `Message ${state.notifications.length + 1}`
          })
        }
      >
        Add Notification
      </Button>

      {state.notifications.map((note, index) => (
        <Notification key={index}>{note}</Notification>
      ))}
    </Card>
  );
};

const Grid = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
`;

const Dashboard = () => {
  return (
    <Grid>
      <Counter />
      <ThemeToggle />
      <NotificationPanel />
    </Grid>
  );
};

const MainApp = () => {
  const { state } = useAppContext();

  return (
    <ThemeProvider theme={state.theme === "light" ? lightTheme : darkTheme}>
      <Container>
        <h1>React Context + Styled Components Demo</h1>
        <Dashboard />
      </Container>
    </ThemeProvider>
  );
};

export default function App() {
  return (
    <AppProvider>
      <MainApp />
    </AppProvider>
  );
}
