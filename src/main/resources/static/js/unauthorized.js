document.addEventListener("DOMContentLoaded", function() {
    let countdown = document.getElementById("countdown");
    let seconds = 5;

    function updateCountdown() {
        seconds--;
        countdown.textContent = seconds;

        if (seconds <= 0) {
            window.location.href = "/auth";
        }
    }

    setInterval(updateCountdown, 1000);
});