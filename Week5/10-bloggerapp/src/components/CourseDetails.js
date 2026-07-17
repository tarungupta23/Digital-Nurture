function getLevelBadge(level) {
  // Conditional rendering technique 4: switch-case
  switch (level) {
    case 'Beginner':
      return <span style={{ color: 'green' }}>Beginner</span>;
    case 'Intermediate':
      return <span style={{ color: 'orange' }}>Intermediate</span>;
    case 'Advanced':
      return <span style={{ color: 'red' }}>Advanced</span>;
    default:
      return <span>Unknown</span>;
  }
}

function CourseDetails(props) {
  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {props.courses.map((course) => (
          <li key={course.id}>
            {course.cname} - {getLevelBadge(course.level)}
          </li>
        ))}
      </ul>

      {/* Conditional rendering technique 5: immediately invoked function expression (IIFE) */}
      {(() => {
        if (props.courses.length === 0) {
          return <p>No courses available right now.</p>;
        }
        return null;
      })()}
    </div>
  );
}

export default CourseDetails;
