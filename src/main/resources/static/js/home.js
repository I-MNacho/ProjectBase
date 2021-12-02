function hideSplashScreen() {
   $('.splash').css({display: 'none'})
}

function showSplashScreen() {
   $('.splash').css({display: 'flex'})
}


   // https://developer.mozilla.org/en-US/docs/Web/API/Window/localStorage
   // Use localStorage api to save whether or not the user has visited the page in the browser
   const storage = localStorage;
   // get "visited" value from local storage
   const hasVisited = false;
   const splashPage = document.getElementById("splash");
   // if hasVisited is false, show splash screen and set "visited" value to true in localStorage
   if(!hasVisited) {
      splashPage.style.display = "flex";
      storage.setItem("visited", "true");
   }
   // checks if user has visited the splash page already and shows the splash page if they have not

