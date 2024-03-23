import React from 'react';

const SecondaryButton = ({ text, click }) => {
  return (
    <button
      type='button'
      className='mx-2 inline-flex justify-center rounded-md border border-transparent text-white bg-secondary px-4 py-2 text-sm font-medium  hover:bg-primary-100 focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500 focus-visible:ring-offset-2'
      onClick={() => click()}
    >
      {text}
    </button>
  );
};

export default SecondaryButton;
