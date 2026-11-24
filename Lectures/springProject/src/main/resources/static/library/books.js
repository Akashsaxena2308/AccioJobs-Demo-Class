const preview = window.location.protocol === 'file:';
const sampleBooks = {
  '101': {id: 101, title: 'Hogwarts Saga', authors: ['Merlin', 'Bilbo'], issued: true},
  '102': {"id":102,"title":"Narnia Story","authors":["Bilbo"],"issued":true},
  '103': {id: 103, title: 'Rivendell Tales', authors: [], issued: false}
};

const el = id => document.getElementById(id);
el('source').textContent = preview ? 'Sample data' : 'Library API';

function renderBook(book) {
  el('book-title').textContent = book.title;
  el('record-id').textContent = book.id;
  el('authors').textContent = book.authors.length ? book.authors.join(', ') : 'No authors listed.';
  el('availability').textContent = book.issued ? 'On loan' : 'Available';
  el('availability').classList.toggle('out', book.issued);
  el('record').hidden = false;
}

let latestSearch = 0;
async function lookupBook() {
  const search = ++latestSearch;
  const id = el('book-id').value.trim();
  el('record').hidden = true;
  el('message').textContent = 'Looking up book…';
  try {
    const book = preview ? sampleBooks[id] : await fetchBook(id);
    if (search !== latestSearch) return;
    if (!book) throw new Error('No book found with ID ' + id + '.');
    renderBook(book);
    el('message').textContent = 'Showing the record for ' + book.title + '.';
  } catch (error) {
    if (search !== latestSearch) return;
    el('message').textContent = error instanceof TypeError
      ? 'Could not reach the library API. Check that Spring Boot is running and try again.'
      : error.message;
  }
}

el('lookup').addEventListener('submit', event => {
  event.preventDefault();
  lookupBook();
});
lookupBook();
