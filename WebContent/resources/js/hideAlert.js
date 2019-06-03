/**
 * Jaime Ramirez
 * 03/06/2019
 * Oculta alert 
 */
let stateCheck = setInterval(() => {
		  if (document.readyState === 'complete') {
		    clearInterval(stateCheck);
		    // document ready
		    var el = document.getElementById("alerta");
		    el.style.display = (el.style.display == 'none') ? 'block' : 'none';
		  }
          }, 5000);