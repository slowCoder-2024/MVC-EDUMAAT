!function($) {
    "use strict";

    var Opportunities = function() {};

    Opportunities.prototype.init = function () {
        
        //Pie Chart
        c3.generate({
             bindto: '#pie-chart',
            data: {
                columns: [
                    ['Good', 46],
                    ['Dormant', 24],
                    ['Following Up', 46],
                    ['Lost', 10],
                    ['Converted', 30]
                ],
                type : 'pie'
            },
            color: {
            	pattern: ["#34d3eb", "#7266ba", "#ffbd4a", "#f05050", "#81c868"]
            },
            pie: {
		        label: {
		          show: false
		        }
		    }
        });
        
    },
    $.Opportunities = new Opportunities, $.Opportunities.Constructor = Opportunities

}(window.jQuery),

//initializing 
function($) {
    "use strict";
    $.Opportunities.init()
}(window.jQuery);



