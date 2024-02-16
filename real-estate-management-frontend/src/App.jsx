import Navbar from './components/layout/Navbar';
import { testFunction } from './utils/utils';

const App = () => {
  testFunction();
  return (
    <>
      <Navbar></Navbar>
    </>
  );
};

export default App;
