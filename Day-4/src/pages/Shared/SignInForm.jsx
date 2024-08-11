
// import React, { useState } from 'react';
// import { useNavigate } from 'react-router-dom';
// import { ToastContainer, toast } from 'react-toastify';
// import 'react-toastify/dist/ReactToastify.css';
// const SignInForm = ({ toggle }) => {

//   const [username, setUsername] = useState('');
//   const [password, setPassword] = useState('');
//   const navigate = useNavigate();
//   const validateForm = (e) => {
//     e.preventDefault();
//     if (!username || !password ) {
//       toast.error('Please fill in all fields', {
//         position: "top-right",
//         autoClose: 1000,
//         hideProgressBar: false,
//         closeOnClick: true,
//         pauseOnHover: true,
//         draggable: true,
//         progress: undefined,
//         theme: "light",
//       });
//     } else {
//       toast.success('Sign Up Successful!', {
//         position: "top-right",
//         autoClose: 1000,
//         hideProgressBar: false,
//         closeOnClick: true,
//         pauseOnHover: true,
//         draggable: true,
//         progress: undefined,
//         theme: "colored",
//         onClose: ()=>navigate('/user/dashboard')
//       });
//     }
//   };
// return(
//   <>
//     <div className=" h-screen w-screen flex  items-center">
         
//                <div className="form sign-in" style={{ marginLeft: '50%' }}>
 
//         <div className="input-group relative w-full my-4">
//             <i className='bx bxs-user absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
//             <input type="text" placeholder="Username" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" value={username} onChange={(e) => setUsername(e.target.value)} required />
//         </div>
//         <div className="input-group relative w-full my-4">
//             <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
//             <input type="password" placeholder="Password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary"value={password} onChange={(e) => setPassword(e.target.value)} required />
//         </div>
       
//         <button className="w-full p-3 text-lg text-white rounded-md"
//     style={{ backgroundColor: '#57B894' }}onClick = {validateForm}
// >
//     Sign in

// </button>
//         <p className="my-4 text-sm">
//             <b>Forgot password?</b>
//         </p>
//         <p className="my-4 text-sm">
//             <span>Don't have an account?</span>
//             <b onClick={toggle} className="cursor-pointer">Sign up here</b>
//         </p>
//     </div>
//     </div>
//         <ToastContainer
//             position="top-right"
//             autoClose={5000}
//             hideProgressBar={false}
//             newestOnTop={false}
//             closeOnClick
//             rtl={false}
//             pauseOnFocusLoss
//             draggable
//             pauseOnHover
//             theme="light"
//           />
//     </>
// )
   
// };

// export default SignInForm;
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const SignInForm = ({ toggle }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const validateForm = (e) => {
    e.preventDefault();
    if (!username || !password) {
      setError('Please fill in all fields');
    } else if (username !== 'sharon' || password !== '1713') {
      setError('Invalid Username / Password');
    } else {
      setError('');
      navigate('/user/dashboard');
    }
  };

  return (
    <>
      <div className="h-screen w-screen flex items-center">
        <div className="form sign-in" style={{ marginLeft: '50%' }}>
          <div className="input-group relative w-full my-4">
            <i className='bx bxs-user absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input
              type="text"
              placeholder="Username"
              className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <div className="input-group relative w-full my-4">
            <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input
              type="password"
              placeholder="Password"
              className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          {error && <p className="text-red-600">{error}</p>}
          <button
            className="w-full p-3 text-lg text-white rounded-md"
            style={{ backgroundColor: '#57B894' }}
            onClick={validateForm}
          >
            Sign in
          </button>
          <p className="my-4 text-sm">
            <b>Forgot password?</b>
          </p>
          <p className="my-4 text-sm">
            <span>Don't have an account?</span>
            <b onClick={toggle} className="cursor-pointer">Sign up here</b>
          </p>
        </div>
      </div>
    </>
  );
};

export default SignInForm;
