
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
const SignInForm = ({ toggle }) => {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const validation = (e) => {
    e.preventDefault();

    if (!username || !password) {
      toast.error('Please fill in both fields', {
        position: "top-right",
        autoClose: 1000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    } else if (username === 'sharon' && password === '1713') {
      toast.success("Sign In Successful!", {
        position: "bottom-right",
        autoClose: 1000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "colored",
      });
      
    } else {
      toast.error('Invalid Username / Password', {
        position: "bottom-left",
        autoClose: 3000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    }
  };
return(
    <div className=" h-screen w-screen flex  items-center">
         
               <div className="form sign-in" style={{ marginLeft: '50%' }}>
 
        <div className="input-group relative w-full my-4">
            <i className='bx bxs-user absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="text" placeholder="Username" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" value={username} onChange={(e) => setUsername(e.target.value)} required />
        </div>
        <div className="input-group relative w-full my-4">
            <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="password" placeholder="Password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary"value={password} onChange={(e) => setPassword(e.target.value)} required />
        </div>
       
        <button className="w-full p-3 text-lg text-white rounded-md"
    style={{ backgroundColor: '#57B894' }}onClick = {validation}
>
        <Link to='/user/dashboard'>
    
    Sign in
</Link>
</button>
        <p className="my-4 text-sm">
            <b>Forgot password?</b>
        </p>
        <p className="my-4 text-sm">
            <span>Don't have an account?</span>
            <b onClick={toggle} className="cursor-pointer">Sign up here</b>
        </p>
        <ToastContainer
            position="bottom-left"
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
    </div>
    </div>
)
   
};

export default SignInForm;
