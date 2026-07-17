function BlogDetails(props) {
  return (
    <div>
      <h2>Blog Details</h2>

      {/* Conditional rendering technique 2: ternary operator */}
      {props.blogs.length > 0 ? (
        <ul>
          {props.blogs.map((blog) => (
            <li key={blog.id}>{blog.title} - by {blog.author}</li>
          ))}
        </ul>
      ) : (
        <p>No blogs published yet.</p>
      )}

      {/* Conditional rendering technique 3: logical && operator */}
      {props.blogs.length > 0 && <p>Total blogs: {props.blogs.length}</p>}
    </div>
  );
}

export default BlogDetails;
