import React from 'react';
import Navbar from './Navbar';
import { Outlet } from 'react-router-dom';

const Wrapper = () => {
  return (
    <>
      <Navbar />
      <Outlet />
    </>
  );
};

export default Wrapper;
