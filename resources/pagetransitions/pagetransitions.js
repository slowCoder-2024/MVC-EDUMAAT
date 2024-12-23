 $( function() {
    // run the currently selected effect
    function runEffectInCreate() {
      // get effect type from
      var selectedEffect = $('#ListDiv').attr('class');
      // Most effect types need no options passed by default
      var options = {};
      // Run the effect
      $( "#ListDiv" ).effect( selectedEffect, options,1000, callback);
    };
    // Callback function to bring a hidden box back
    function callback() {
      setTimeout(function() {
    	  var selectedEffect =$('#FormDiv').attr('class');
    	  var options = {};
          // some effects have required parameters
    	  $( "#FormDiv" ).effect( selectedEffect, options,500);
    	  document.getElementById('FormDiv').style.display="block";
      },100);
    };
    // Set effect from select menu value
    $( ".createanimate" ).on( "click", function() {
      runEffectInCreate();
      return false;
    });
  } );
/*  $( function() {
    // run the currently selected effect
    function runEffectInEdit() {
      // get effect type from
      var selectedEffect = $('#ListDiv').attr('class');
      // Most effect types need no options passed by default
      var options = {};
      // some effects have required parameters
      // Run the effect
      $( "#ListDiv" ).effect( selectedEffect, options,1000, callback);
    };
    // Callback function to bring a hidden box back
    function callback() {
      setTimeout(function() {
    	  var selectedEffect =$('#EditFormDiv').attr('class');
    	  var options = {};
          // some effects have required parameters
    	  $( "#EditFormDiv" ).effect( selectedEffect, options,500);
    	  document.getElementById('EditFormDiv').style.display="block";
      },100);
    };
    // Set effect from select menu value
    $( ".editanimate" ).on( "click", function() {
      runEffectInEdit();
      return false;
    });
  } );*/