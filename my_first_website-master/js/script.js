const button = document.getElementById("loadPosts");
const container = document.getElementById("postsContainer");
const errorMessage = document.getElementById("errorMessage");
const searchInput = document.getElementById("searchInput");

let allPosts = [];

button.addEventListener("click", fetchPosts);
searchInput.addEventListener("input", filterPosts);

async function fetchPosts() {
    container.innerHTML = "";
    errorMessage.textContent = "";

    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts");

        if (!response.ok) {
            throw new Error("Failed to fetch data. Please try again.");
        }

        const data = await response.json();

        allPosts = data.slice(0, 20);
        displayPosts(allPosts);

    } catch (error) {
        errorMessage.textContent = error.message;
    }
}

function displayPosts(posts) {
    container.innerHTML = "";

    if (posts.length === 0) {
        container.innerHTML = "<p>No posts found.</p>";
        return;
    }

    posts.forEach(post => {
        const div = document.createElement("div");
        div.className = "post";
        div.innerHTML = `
            <h3>${post.title}</h3>
            <p>${post.body}</p>
        `;
        container.appendChild(div);
    });
}

function filterPosts() {
    const searchText = searchInput.value.toLowerCase();

    const filtered = allPosts.filter(post =>
        post.title.toLowerCase().includes(searchText)
    );

    displayPosts(filtered);
}