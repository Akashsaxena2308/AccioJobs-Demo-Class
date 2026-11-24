const el = id => document.getElementById(id);
const preview = location.protocol === 'file:';
el('source').textContent = preview ? 'Sample data' : 'Library API';

const sampleShelves = {
  'NORTH/1': 'Hogwarts Saga',
  'NORTH/2': 'Narnia Story',
  'SOUTH/1': 'Rivendell Tales'
};

function renderShelf(shelf) {
  el('book-title').textContent = shelf.book;
  el('room-result').textContent = shelf.roomCode;
  el('position-result').textContent = shelf.position;
  el('record').hidden = false;
}

const form = el('lookup');
form.addEventListener('submit', async event => {
  event.preventDefault();
  const room = el('room').value.trim().toUpperCase();
  const position = el('position').value;
  const button = form.querySelector('button');
  button.disabled = true;
  el('record').hidden = true;
  el('message').textContent = 'Looking up shelf…';
  try {
    let shelf;
    if (preview) {
      const book = sampleShelves[room + '/' + position];
      if (!book) throw new Error('Shelf position not found.');
      shelf = {roomCode: room, position, book};
    } else {
      shelf = await fetchShelf(room, position);
    }
    renderShelf(shelf);
    el('message').textContent = '';
  } catch (error) {
    el('message').textContent = error.message;
  } finally {
    button.disabled = false;
  }
});
