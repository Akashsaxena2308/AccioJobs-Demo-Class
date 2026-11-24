// Called by the search form when Spring Boot serves the page.
async function fetchStudent(id) {
  const response = await fetch('/jpa/library/student/' + encodeURIComponent(id));
  if (response.status === 404) {
    throw new Error('No student found with ID ' + id + '.');
  }
  if (!response.ok) {
    throw new Error('Student lookup failed (HTTP ' + response.status + ').');
  }
  return response.json();
}

async function fetchBook(id) {
  const response = await fetch('/jpa/library/books/' + encodeURIComponent(id));
  if (response.status === 404) {
    throw new Error('No book found with ID ' + id + '.');
  }
  if (!response.ok) {
    throw new Error('Book lookup failed (HTTP ' + response.status + ').');
  }
  return response.json();
}

async function fetchShelf(room, position) {
  // Replace this line during the live integration exercise.
  throw new Error('Shelf lookup is ready to connect.');
}
