
	
	function MergeGridCells() {
    var dimension_cells = new Array();
    var dimension_col = null;
    var columnCount = $(".table tr:first th").length;
    for (dimension_col = 0; dimension_col < columnCount; dimension_col++) {
        // first_instance holds the first instance of identical td
        var first_instance = null;
        var rowspan = 1;
        // iterate through rows
        $(".table").find('tr').each(function () {

            // find the td of the correct column (determined by the dimension_col set above)
            var dimension_td = $(this).find('td:nth-child(' + dimension_col + ')');

            if (first_instance == null) {
                // must be the first row
                first_instance = dimension_td;
            } else if (dimension_td.text() == first_instance.text()) {
                // the current td is identical to the previous
                // remove the current td
                dimension_td.remove();
                ++rowspan;
                // increment the rowspan attribute of the first instance
                first_instance.attr('rowspan', rowspan);
            } else {
                // this cell is different from the last
                first_instance = dimension_td;
                rowspan = 1;
            }
        });
    }
}