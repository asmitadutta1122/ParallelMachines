function getTheaterList() {
	var uri = "http://localhost:8080/movieTicket/rest/movie/theaterList";
	var showData = $('#show-data');
	function getData( data ) {
	     var items1 = [];
	     $.each( data, function( key, val ) {
	    	 console.log(val.movie.movie);
	       items1.push( "<li id='" + key + "'>" + val.movie.theaterName + "</li>" );
	     });
	     showData.empty();
	     if (items1.length) {
	    	 var list = $('<ul />').html(items1.join(""));
	    	 showData.append(list);
	     }
	}
	httpGetAsync(uri, getData);
	showData.text('Loading the JSON file.');
}

function getMovieList() {
	var uri = "http://localhost:8080/movieTicket/rest/movie/movieList";
	var showData = $('#show-data');
	function getData( data ) {
	     console.log("Complete " + data);
	     var items1 = [];
	     $.each( data, function( key, val ) {
	    	 console.log(val.movie.movie);
	       items1.push( "<li id='" + key + "'>" + val.movie.movie + "</li>" );
	     });
	     showData.empty();
	     if (items1.length) {
	    	 var list = $('<ul />').html(items1.join(""));
	    	 showData.append(list);
	     }
	}
	showData.text('Loading the JSON file.');
	httpGetAsync(uri, getData);
}

function httpGetAsync(url, callbackFn) {
	$.getJSON(url, function (data) {
	    callbackFn(data);
	  });
}