//variable to store the search input value
var radioValue = '';
var searchInput;
//add action listener when the search button is clicked
document.getElementById('search-btn').addEventListener('click', checkValue);
var radioChecked = false; //for the checked radio button, initialized to false

function checkValue() {

    var files = document.getElementsByName('file'); //array to store all file names

    searchInput = document.getElementById('search-input').value; //the input value

    //from the files array, find the checked radio button and return its value
    for (var i = 0; i < files.length; i++) {
        if (files[i].checked) {
            radioValue = files[i].value;
            
        }
    }
    displayData();

}

function displayData() {

    if ((radioValue.length>0) && (searchInput.length>0)) {
        //console.log('Search iput is = ' + searchInput);
        //console.log('Radio value is ' + radioValue + ' and = ' + radioChecked);
    }

    else{
        alert('pick a search option');
    }
}