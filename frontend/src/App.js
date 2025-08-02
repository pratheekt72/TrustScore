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

      if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);

      const data = await response.json();
      updateOutput(JSON.stringify(data, null, 2));
      console.log("🚀 TrustScore CI/CD works!");

    } catch (err) {
      console.error(err);
      updateOutput("Unfortunately, there was trouble connecting to the backend");
    }
  };

  return (
    <div style={{
      minHeight: "100vh",
      background: "linear-gradient(135deg, #000000, #1c1c1c)",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      fontFamily: "'Segoe UI', sans-serif",
      padding: "20px",
    }}>
      <div style={{
        backgroundColor: "#121212",
        padding: "40px",
        borderRadius: "16px",
        boxShadow: "0 10px 30px rgba(255, 215, 0, 0.2)",
        maxWidth: "600px",
        width: "100%",
        border: "1px solid #ffd700",
      }}>
        <h1 style={{ textAlign: "center", color: "#ffd700", marginBottom: "30px" }}>
          TrustScorE
        </h1>

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
              border: "1px solid #555",
              borderRadius: "8px",
              backgroundColor: "#1e1e1e",
              color: "#ffd700",
              marginRight: "10px",
            }}
          />
          <button
            onClick={handleSubmit}
            style={{
              backgroundColor: "#ffd700",
              color: "#000",
              border: "none",
              borderRadius: "8px",
              padding: "12px 20px",
              cursor: "pointer",
              fontSize: "16px",
              fontWeight: "bold",
              transition: "0.2s",
            }}
            onMouseOver={(e) => e.currentTarget.style.backgroundColor = "#e6c200"}
            onMouseOut={(e) => e.currentTarget.style.backgroundColor = "#ffd700"}
          >
            Submit
          </button>
        </div>

        <h2 style={{ color: "#ccc", fontSize: "18px" }}>Result:</h2>
        <pre style={{
          backgroundColor: "#1e1e1e",
          padding: "15px",
          borderRadius: "8px",
          border: "1px solid #ffd700",
          color: "#f5f5f5",
          fontSize: "14px",
          fontFamily: "Courier New, monospace",
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
