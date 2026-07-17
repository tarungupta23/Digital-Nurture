function BookDetails(props) {
  const bookdet = (
    <ul>
      {props.books.map((book) => (
        <div key={book.id}>
          <h3> {book.bname}</h3>
          <h4>Rs. {book.price}</h4>
        </div>
      ))}
    </ul>
  );

  const noBooks = <p>No books available.</p>;

  // Conditional rendering technique 1: element variables + if/else
  let content;
  if (props.books.length > 0) {
    content = bookdet;
  } else {
    content = noBooks;
  }

  return (
    <div>
      <h2>Book Details</h2>
      {content}
    </div>
  );
}

export default BookDetails;
