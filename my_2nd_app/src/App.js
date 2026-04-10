import React, { useEffect, useState } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

function DataFetcher({ url }) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true);
    fetch(url)
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch");
        return res.json();
      })
      .then((json) => {
        setData(json.slice(0, 10));
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, [url]);

  if (loading) return <p>Loading...</p>;
  if (error) return <p style={{ color: "red" }}>Error: {error}</p>;

  return (
    <ul>
      {data.map((item) => (
        <li key={item.id}>{item.title || item.name}</li>
      ))}
    </ul>
  );
}

function Home() {
  return <h2>Welcome to React Router App</h2>;
}

function Users() {
  return (
    <div>
      <h2>Users</h2>
      <DataFetcher url="https://jsonplaceholder.typicode.com/users" />
    </div>
  );
}

function Posts() {
  return (
    <div>
      <h2>Posts</h2>
      <DataFetcher url="https://jsonplaceholder.typicode.com/posts" />
    </div>
  );
}

function Todos() {
  return (
    <div>
      <h2>Todos</h2>
      <DataFetcher url="https://jsonplaceholder.typicode.com/todos" />
    </div>
  );
}

function Navbar() {
  return (
    <nav style={{ display: "flex", gap: "15px", marginBottom: "20px" }}>
      <Link to="/">Home</Link>
      <Link to="/users">Users</Link>
      <Link to="/posts">Posts</Link>
      <Link to="/todos">Todos</Link>
    </nav>
  );
}

export default function App() {
  return (
    <Router>
      <div style={{ padding: "20px" }}>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/users" element={<Users />} />
          <Route path="/posts" element={<Posts />} />
          <Route path="/todos" element={<Todos />} />
        </Routes>
      </div>
    </Router>
  );
}
