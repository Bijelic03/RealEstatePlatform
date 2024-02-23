import React from 'react';
import { Dialog, Transition } from '@headlessui/react';
import { Fragment } from 'react';
import PrimaryButton from './core/PrimaryButton';
import SecondaryButton from './core/SecondaryButton';

const Register = ({ isOpenRegister, handleOpenRegister }) => {
  return (
    <Transition appear show={isOpenRegister} as={Fragment}>
      <Dialog as='div' className='relative z-10' onClose={() => handleOpenRegister()}>
        <Transition.Child
          as={Fragment}
          enter='ease-out duration-300'
          enterFrom='opacity-0'
          enterTo='opacity-100'
          leave='ease-in duration-200'
          leaveFrom='opacity-100'
          leaveTo='opacity-0'
        >
          <div className='fixed inset-0 bg-black/25' />
        </Transition.Child>

        <div className='fixed inset-0 overflow-y-auto'>
          <div className='flex min-h-full items-center justify-center p-4 text-center'>
            <Transition.Child
              as={Fragment}
              enter='ease-out duration-300'
              enterFrom='opacity-0 scale-95'
              enterTo='opacity-100 scale-100'
              leave='ease-in duration-200'
              leaveFrom='opacity-100 scale-100'
              leaveTo='opacity-0 scale-95'
            >
              <Dialog.Panel className='w-full max-w-md transform overflow-hidden rounded-2xl bg-white p-6 text-left align-middle shadow-xl transition-all'>
                <Dialog.Title as='h3' className='text-lg font-semibold leading-6 text-gray-900'>
                  Register
                </Dialog.Title>
                <div className='mt-2 '>
                  <form>
                    <div className='flex flex-col p-5 '>
                      <div className='flex flex-col md:flex-row  md:space-x-5'>
                        <div>
                          <input className='outline-none border-b-2 py-1'></input>
                          <label>Name</label>
                        </div>
                        <div>
                          <input className='outline-none border-b-2 py-1'></input>
                          <label>Surname</label>
                        </div>
                      </div>
                      <input className='outline-none mt-3 border-b-2 py-1'></input>

                      <label>Email</label>
                      <input className='outline-none mt-3 border-b-2 py-1'></input>

                      <label>Phone Number</label>
                      <input className='outline-none mt-3 border-b-2 py-1'></input>

                      <label>Address</label>
                      <input className='outline-none mt-3 border-b-2 py-1'></input>

                      <label>Password</label>
                      <input type='password' className='outline-none mt-3 border-b-2 py-1'></input>

                      <label type='password'>Repeat Password</label>
                    </div>
                  </form>
                </div>

                <div className='mt-4   flex  justify-end'>
                  <SecondaryButton text='Cancel' click={handleOpenRegister} />

                  <PrimaryButton text='Register' click={handleOpenRegister} />
                </div>
              </Dialog.Panel>
            </Transition.Child>
          </div>
        </div>
      </Dialog>
    </Transition>
  );
};

export default Register;
