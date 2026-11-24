const preview = window.location.protocol === 'file:';
const exampleStudents = {
  '301': {id: 301, name: 'Luna', cardCode: 'RAVEN-CARD', loans: [
    {book: 'Hogwarts Saga', issuedAt: '2026-11-22T09:00:00', returnedAt: '2026-11-22T11:00:00'},
    {book: 'Narnia Story', issuedAt: '2026-11-22T12:00:00', returnedAt: null}
  ]},
  '302': {id: 302, name: 'Hermione', cardCode: 'GRYPH-CARD', loans: [
    {book: 'Hogwarts Saga', issuedAt: '2026-11-22T12:00:00', returnedAt: null}
  ]}
};
const el = id => document.getElementById(id);
el('source').textContent = preview ? 'Sample data' : 'Library API';
const dateFormat = new Intl.DateTimeFormat('en-GB', {
  day: 'numeric', month: 'short', year: 'numeric', hour: '2-digit', minute: '2-digit'
});
function renderStudent(student) {
  el('member-name').textContent = student.name;
  el('member-id').textContent = student.id;
  el('card').textContent = student.cardCode;
  el('rows').replaceChildren();
  for (const loan of student.loans) {
    const row = el('rows').insertRow();
    row.insertCell().textContent = loan.book;
    row.insertCell().textContent = loan.issuedAt ? dateFormat.format(new Date(loan.issuedAt)) : '—';
    row.insertCell().textContent = loan.returnedAt ? dateFormat.format(new Date(loan.returnedAt)) : '—';
    const badge = document.createElement('span');
    badge.className = loan.returnedAt ? 'status' : 'status out';
    badge.textContent = loan.returnedAt ? 'Returned' : 'On loan';
    row.insertCell().append(badge);
  }
  el('ledger').hidden = student.loans.length === 0;
  el('empty').hidden = student.loans.length > 0;
  el('record').hidden = false;
}
let latestSearch = 0;
async function lookup() {
  const search = ++latestSearch;
  const id = el('student-id').value.trim();
  el('record').hidden = true;
  el('message').textContent = 'Looking up student…';
  try {
    const student = preview ? exampleStudents[id] : await fetchStudent(id);
    if (search !== latestSearch) return;
    if (!student) throw new Error('No student found with ID ' + id + '.');
    renderStudent(student);
    el('message').textContent = 'Showing the record for ' + student.name + '.';
  } catch (error) {
    if (search !== latestSearch) return;
    el('message').textContent = error instanceof TypeError
      ? 'Could not reach the library API. Check that Spring Boot is running and try again.'
      : error.message;
  }
}
el('lookup').addEventListener('submit', event => {
  event.preventDefault();
  lookup();
});
lookup();
