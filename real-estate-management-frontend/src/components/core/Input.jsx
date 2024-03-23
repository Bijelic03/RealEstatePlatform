import React from 'react';

const Input = ({ value, onChange, type, placeholder }) => {
  return (
    <input
      value={value}
      onChange={onChange}
      type={type}
      placeholder={placeholder}
      className='outline-none mt-3 border-b-2 py-1'
    ></input>
  );
};

export default Input;
