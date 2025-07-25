import React, { useState } from "react";

function App() {
  const [input, updateInput] = useState("");
  const [output, updateOutput] = useState("");

  const handleSubmit = async () => {
    try {
      const response = await fetch("https://trustscore.duckdns.org/api/trustscore", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ userid: input }),
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const data = await response.json();
      updateOutput(JSON.stringify(data, null, 2));
    } catch (err) {
      console.error(err);
      updateOutput("Unfortunately, there was trouble connecting to the backend");
    }
  };

  return (
    <div style={{
      minHeight: "100vh",
      backgroundColor: "#f0f8ff",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      fontFamily: "Segoe UI, sans-serif",
      padding: "20px",
    }}>
      <div style={{
        backgroundColor: "#d11717ff",
        padding: "40px",
        borderRadius: "12px",
        boxShadow: "0 10px 25px rgba(202, 216, 8, 0.1)",
        maxWidth: "600px",
        width: "100%",
      }}>
        <h1 style={{ textAlign: "center", color: "#0fcfa2ff", marginBottom: "30px" }}>Project</h1>

        <div style={{ display: "flex", marginBottom: "20px" }}>
          <input
            type="text"
            placeholder="Enter User ID"
            value={input}
            onChange={(e) => updateInput(e.target.value)}
            style={{
              flex: 1,
              padding: "12px 16px",
              fontSize: "16px",
              border: "1px solid #ccc",
              borderRadius: "8px",
              marginRight: "10px",
            }}
          />

          <button
            onClick={handleSubmit}
            style={{
              backgroundColor: "#007acc",
              color: "white",
              border: "none",
              borderRadius: "8px",
              padding: "12px 20px",
              cursor: "pointer",
              fontSize: "16px",
            }}
          >
            Submit
          </button>
        </div>

        <h2 style={{ color: "#333", fontSize: "20px" }}>Result:</h2>
        <pre style={{
          backgroundColor: "#f9f9f9",
          padding: "15px",
          borderRadius: "8px",
          border: "1px solid #ddd",
          whiteSpace: "pre-wrap",
          wordBreak: "break-word",
        }}>
          {output}
        </pre>
      </div>
    </div>
  );
}

export default App;
