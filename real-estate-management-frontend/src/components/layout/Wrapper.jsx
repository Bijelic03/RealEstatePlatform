import React from 'react';
import Navbar from './Navbar';
import { Outlet } from 'react-router-dom';

const Wrapper = () => {
  return (
    <>
      <Navbar />
      <div className='mx-10 md:mx-52 '>
        <Outlet />
      </div>
    </>
  );
};

export default Wrapper;
