// import React from 'react';
// import { Link } from 'react-router-dom';
// const SignUpForm = ({ toggle }) => (
//     <div className="h-screen w-screen flex items-center ">
//         <div className="form sign-up"style={{ marginRight: '30%', marginLeft: '-30%' }}>
//         <div className="input-group relative w-full my-4">
//             <i className='bx bxs-user absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
//             <input type="text" placeholder="Username" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
//         </div>
//         <div className="input-group relative w-full my-4">
//             <i className='bx bx-mail-send absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
//             <input type="email" placeholder="Email" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
//         </div>
//         <div className="input-group relative w-full my-4">
//             <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
//             <input type="password" placeholder="Password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
//         </div>
//         <div className="input-group relative w-full my-4">
//             <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
//             <input type="password" placeholder="Confirm password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
//         </div>
       
//         <button
//     className="w-full p-3 text-lg text-white rounded-md"
//     style={{ backgroundColor: '#57B894' }}
// >
//     Sign up
// </button>

//         <p className="my-4 text-sm">
//             <span>Already have an account?</span>
//             <b onClick={toggle} className="cursor-pointer">Sign in here</b>
//         </p>
//     </div>
//     </div>
// );

// export default SignUpForm;

import React, { useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';

const SignUpForm = ({ toggle }) => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const navigate = useNavigate();

  const validateForm = (e) => {
    e.preventDefault();
    if (!username || !email || !password || !confirmPassword) {
      toast.error('Please fill in all fields', {
        position: "top-right",
        autoClose: 1000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    } else if (password !== confirmPassword) {
      toast.error('Passwords do not match', {
        position: "top-right",
        autoClose: 1000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    } else {
      toast.success('Sign Up Successful!', {
        position: "top-right",
        autoClose: 1000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "colored",
        onClose: ()=>navigate('/login')
      });
    }
  };

  return (
    <>
      <div className="h-screen w-screen flex items-center">
        <div className="form sign-up" style={{ marginRight: '30%', marginLeft: '-30%' }}>
          <div className="input-group relative w-full my-4">
            <i className='bx bxs-user absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="text" placeholder="Username" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" value={username} onChange={(e) => setUsername(e.target.value)} />
          </div>
          <div className="input-group relative w-full my-4">
            <i className='bx bx-mail-send absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="email" placeholder="Email" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" value={email} onChange={(e) => setEmail(e.target.value)} />
          </div>
          <div className="input-group relative w-full my-4">
            <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="password" placeholder="Password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" value={password} onChange={(e) => setPassword(e.target.value)} />
          </div>
          <div className="input-group relative w-full my-4">
            <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="password" placeholder="Confirm password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} />
          </div>

          <button
            className="w-full p-3 text-lg text-white rounded-md"
            style={{ backgroundColor: '#57B894' }}
            onClick={validateForm}
          >
            Sign up
          </button>

          <p className="my-4 text-sm">
            <span>Already have an account?</span>
            <b onClick={toggle} className="cursor-pointer">Sign in here</b>
          </p>
        </div>
      </div>
      <ToastContainer
        position="top-right"
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
      />
    </>
  );
};

export default SignUpForm;
