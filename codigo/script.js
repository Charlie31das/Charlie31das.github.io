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

