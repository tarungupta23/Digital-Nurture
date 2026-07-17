import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

const books = [
  { id: 1, bname: 'Learning React', price: 499 },
  { id: 2, bname: 'JavaScript Essentials', price: 399 },
  { id: 3, bname: 'Modern CSS', price: 349 },
];

const blogs = [
  { id: 1, title: 'Getting started with React', author: 'Steeve' },
  { id: 2, title: 'Understanding Hooks', author: 'Aathma' },
];

const courses = [
  { id: 1, cname: 'React Basics', level: 'Beginner' },
  { id: 2, cname: 'Advanced React Patterns', level: 'Advanced' },
  { id: 3, cname: 'State Management', level: 'Intermediate' },
];

function App() {
  return (
    <div>
      <h1>Blogger App</h1>
      <BookDetails books={books} />
      <hr/>
      <BlogDetails blogs={blogs} />
      <hr/>
      <CourseDetails courses={courses} />
    </div>
  );
}

export default App;
