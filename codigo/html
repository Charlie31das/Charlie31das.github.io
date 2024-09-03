<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Juego de Oca</title>
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f0f0f0;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 600px;
        }
        .text-mono {
            font-family: monospace;
            font-size: 24px;
            color: #333;
        }
        .typing-effect-cursor {
            font-weight: bold;
            animation: blink 0.7s infinite;
        }
        @keyframes blink {
            0% { opacity: 1; }
            50% { opacity: 0; }
            100% { opacity: 1; }
        }
        .form-section {
            margin-top: 20px;
            display: none;
        }
        .form-control {
            margin-top: 10px;
            padding: 10px;
            font-size: 16px;
            width: 100%;
        }
        .submit-button {
            margin-top: 20px;
            padding: 10px;
            background-color: #b81414;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        .board {
            display: none;
            margin-top: 20px;
        }
        .board div {
            display: flex;
            flex-wrap: wrap;
            width: 300px;
            height: 300px;
            margin: 0 auto;
        }
        .board .square {
            width: 30px;
            height: 30px;
            background-color: #e0e0e0;
            border: 1px solid #ccc;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .board .square:nth-child(even) {
            background-color: #d0d0d0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="px-sm-0 px-4">
            <span id="typing-effect-1" class="text-mono"></span>
            <span id="typing-effect-2" class="text-mono"></span>
            <span id="typing-effect-cursor" class="typing-effect-cursor">|</span>
        </div>

        <div id="email-container" class="form-section">
            <label for="email" class="text-mono">Enter your email<sup>*</sup></label>
            <input id="email" class="form-control" type="email" name="user[email]" placeholder="you@example.com" required>
            <button id="email-continue" class="submit-button">Continuar</button>
        </div>

        <div id="name-container" class="form-section">
            <label for="name" class="text-mono">Enter your name<sup>*</sup></label>
            <input id="name" class="form-control" type="text" name="user[name]" required>
            <button id="name-continue" class="submit-button">Continuar</button>
        </div>

        <div id="position-container" class="form-section">
            <label for="position" class="text-mono">Enter your position<sup>*</sup></label>
            <input id="position" class="form-control" type="text" name="user[position]" required>
            <button id="position-submit" class="submit-button">Submit</button>
        </div>

        <div id="board-container" class="board">
            <div>
                <!-- Board squares -->
                <!-- Adjust the number of squares and their arrangement as needed -->
                <!-- Example layout -->
                <div class="square">1</div>
                <div class="square">2</div>
                <div class="square">3</div>
                <div class="square">4</div>
                <div class="square">5</div>
                <div class="square">6</div>
                <div class="square">7</div>
                <div class="square">8</div>
                <div class="square">9</div>
                <div class="square">10</div>
                <!-- Continue adding squares to create the board -->
            </div>
        </div>
    </div>

    <script>
        function typeText(text, elementId, callback) {
            let index = 0;
            const speed = 50;  // Adjusted for faster typing speed
            const element = document.getElementById(elementId);

            function typeWriter() {
                if (index < text.length) {
                    element.innerHTML += text.charAt(index);
                    index++;
                    setTimeout(typeWriter, speed);
                } else if (callback) {
                    callback();
                }
            }
            typeWriter();
        }

        function showFormSection(sectionId) {
            document.getElementById(sectionId).style.display = 'block';
        }

        function hideAllSections() {
            document.querySelector('.container').style.display = 'none';
        }

        function showBoard() {
            document.getElementById('board-container').style.display = 'block';
        }

        // Start the typing effect
        typeText("Welcome to I2B Tech!", "typing-effect-1", function() {
            typeText("<br>Let’s begin the adventure", "typing-effect-2", function() {
                document.getElementById("typing-effect-cursor").style.display = 'none';
                showFormSection("email-container");
            });
        });

        document.getElementById("email-continue").addEventListener("click", function() {
            const email = document.getElementById("email").value;
            if (email.includes("@")) {
                showFormSection("name-container");
            } else {
                alert("Please enter a valid email address.");
            }
        });

        document.getElementById("name-continue").addEventListener("click", function() {
            showFormSection("position-container");
        });

        document.getElementById("position-submit").addEventListener("click", function() {
            hideAllSections();
            showBoard();
        });
    </script>
</body>
</html>
