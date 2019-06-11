var gulp        = require('gulp');
var browserSync = require('browser-sync').create();
var reload      = browserSync.reload;

// Save a reference to the `reload` method

// Watch scss AND html files, doing different things with each.
gulp.task('server', function () {
	 
	browserSync.init({
		proxy:{target :"localhost:8080/CRUD_JSP_Hibernate_Sesion_Report",
			   
			   ws: true 
			}
		});
	    
	   gulp.watch('Views/Service/*.jsp').on('change', reload);
    });
// watch files for changes


//gulp.task('default', gulp.series('browser-sync', 'watch'));