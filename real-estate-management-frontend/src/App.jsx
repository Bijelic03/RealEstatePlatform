import Navbar from './components/layout/Navbar';
import { testFunction } from './utils/utils';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Wrapper from './components/layout/Wrapper';
import HomePage from './pages/HomePage';
import EstatesPage from './pages/EstatesPage';
import ProfilePage from './pages/ProfilePage';
import PropertiesPage from './pages/PropertiesPage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Wrapper />,
    children: [
      { path: '/', element: <HomePage /> },
      { path: '/estates', element: <EstatesPage /> },
      { path: '/profile', element: <ProfilePage /> },
      { path: '/properties', element: <PropertiesPage /> }
    ]
  }
]);

const App = () => {
  testFunction();
  return <RouterProvider router={router} />;
};

export default App;
