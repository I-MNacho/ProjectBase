(() => {
   const storage = localStorage
   const hasVisited = localStorage.getItem("visited")
   const splashPage = document.getElementById("splash")

   if(!hasVisited) {
      splashPage.style.display = "flex"
      storage.setItem("visited", "true")
   }

})()