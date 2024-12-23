var JsDBSource = {
    loadData: function (filter) {
        console.log(filter);
        var d = $.Deferred();
        $.ajax({
            type: "GET",
            url: "data/jsgrid.json",
            data: filter,
            success: function(response) {
                //we have put static filter on front-end side, you should actually filter data on back-end side
                var filtered_data = $.grep(response, function (client) {
                    return (!filter.Name || client.Name.indexOf(filter.Name) > -1)
                        && (!filter.Age || client.Age === filter.Age)
                        && (!filter.Address || client.Address.indexOf(filter.Address) > -1)
                        && (!filter.Country || client.Country === filter.Country)
                });
                d.resolve(filtered_data);
            }
        });
        return d.promise();
    },

    insertItem: function (item) {
        return $.ajax({
            type: "POST",
            url: "data/jsgrid.json",
            data: item
        });
    },

    updateItem: function (item) {
        return $.ajax({
            type: "PUT",
            url: "data/jsgrid.json",
            data: item
        });
    },

    deleteItem: function (item) {
        return $.ajax({
            type: "DELETE",
            url: "data/jsgrid.json",
            data: item
        });
    },

    countries: [
        { Name: "", Id: 0 },
        { Name: "India", Id: 1 },
        { Name: "Kenya", Id: 2 },
        { Name: "Rwanda", Id: 3 },
        { Name: "Nigeria", Id: 4 },
        { Name: "South Africa", Id: 5 },
        { Name: "Tanzania", Id: 6 },
        { Name: "US", Id: 7 }
    ]
};



!function($) {
    "use strict";

    var GridApp = function() {
        this.$body = $("body")
    };
    GridApp.prototype.createGrid = function ($element, options) {
        //default options
        var defaults = {
            height: "450",
            width: "100%",
            filtering: true,
            editing: true,
            inserting: true,
            sorting: true,
            paging: true,
            autoload: true,
            pageSize: 10,
            pageButtonCount: 5,
            deleteConfirm: "Do you really want to delete the entry?"
        };

        $element.jsGrid($.extend(defaults, options));
    },
    GridApp.prototype.init = function () {
        var $this = this;

        var options = {
            fields: [
                {name: "Name", type: "text", width: 150},
                {name: "Age", type: "number", width: 50},
                {name: "Address", type: "text", width: 200},
                {name: "Country", type: "select", items: JsDBSource.countries, valueField: "Id", textField: "Name"},
                {type: "control"}
            ],
            controller: JsDBSource,
        };
        $this.createGrid($("#jsGrid"), options);

    },
    //init ChatApp
    $.GridApp = new GridApp, $.GridApp.Constructor = GridApp

}(window.jQuery),

//initializing main application module
function($) {
    "use strict";
    $.GridApp.init();
}(window.jQuery);