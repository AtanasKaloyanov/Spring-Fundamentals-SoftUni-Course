function sortArray(arr, order) {
    let sortingNumbers = (a,b) => a - b;

    if (order === 'asc') {
        return arr.sort(sortingNumbers);
    }

    return arr.sort(sortingNumbers).reverse();
}


console.log(sortArray([12,14,20,3,7], 'asc'));
console.log(sortArray([12,14,20,3,7], 'desc'));