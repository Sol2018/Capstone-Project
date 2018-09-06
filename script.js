//variable to store the search input value and radio box
var radioValue;
var searchInput;
var ourData;
//to keep track of the current page and where to add data
var currentPage = document.querySelector('#showcase').innerHTML.toLowerCase().trim();
//add action listener when the search button is clicked and invokes the checkValue() function
document.getElementById('search').addEventListener('click', searchFile);



var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', '/sample.json');
ourRequest.onload = function () {
    ourData = JSON.parse(ourRequest.responseText);
    localStorage.setItem('files', JSON.stringify(ourData));
    //alert(ourData[0].title);
};
ourRequest.send();


function searchFile() {
    radioValue = document.querySelector('.dropdown-toggle').value;
    console.log(radioValue);
    searchInput = document.getElementById('search-input').value;
    fileData = JSON.parse(localStorage.getItem('files'));
    //alert(searchInput.length);
    

    if(searchInput.length>0){
        startSearch(fileData);
    }
    else{
        alert("Please enter keyword to search!");
    }
}
//Object to store search results if found
var searchObject = new Object;
    searchObject.title =[];
    searchObject.author =[];
    searchObject.location =[];
    searchObject.size =[];
    searchObject.date =[];
    searchObject.description =[];
    searchObject.href =[];

function startSearch(event){
    for(var i=0; i<fileData.length; i++){
        for(var j=0; j<fileData[i].title.length; j++){
            if((fileData[i].title[j].indexOf(searchInput)>-1)||(fileData[i].author[j].indexOf(searchInput)>-1)||(fileData[i].location[j].indexOf(searchInput)>-1)||(fileData[i].description[j].indexOf(searchInput)>-1)){
                searchObject.title.push(fileData[i].title[j]);
                searchObject.author.push(fileData[i].author[j]);
                searchObject.location.push(fileData[i].location[j]);
                searchObject.size.push(fileData[i].size[j]);
                searchObject.date.push(fileData[i].date[j]);
                searchObject.description.push(fileData[i].description[j]);
                searchObject.href.push(fileData[i].href[j]);

            }
        }
    }

    if(searchObject.title.length>0){
        alert(searchObject.title);
    }
    else{
        alert("No files found matching "+'"'+searchInput+'"');
    }
    
}
