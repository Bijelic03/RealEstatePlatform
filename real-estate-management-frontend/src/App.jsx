import UserPanel from './components/UserPanel';
import Navbar from './components/layout/Navbar';
import { testFunction } from './utils/utils';

const App = () => {
  testFunction();
  return (
    <>
      <Navbar></Navbar>
      <UserPanel />
    </>
  );
};

export default App;
