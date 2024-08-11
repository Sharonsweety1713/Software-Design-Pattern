import React from 'react';
import { Link } from 'react-router-dom';
const SignUpForm = ({ toggle }) => (
    <div className="h-screen w-screen flex items-center ">
        <div className="form sign-up"style={{ marginRight: '30%', marginLeft: '-30%' }}>
        <div className="input-group relative w-full my-4">
            <i className='bx bxs-user absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="text" placeholder="Username" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
        </div>
        <div className="input-group relative w-full my-4">
            <i className='bx bx-mail-send absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="email" placeholder="Email" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
        </div>
        <div className="input-group relative w-full my-4">
            <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="password" placeholder="Password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
        </div>
        <div className="input-group relative w-full my-4">
            <i className='bx bxs-lock-alt absolute top-1/2 left-4 transform -translate-y-1/2 text-xl text-gray-600'></i>
            <input type="password" placeholder="Confirm password" className="w-full p-4 pl-12 text-base bg-gray-200 rounded-md border-white outline-none focus:border-primary" />
        </div>
        <Link to='/login'>
        <button
    className="w-full p-3 text-lg text-white rounded-md"
    style={{ backgroundColor: '#57B894' }}
>
    Sign up
</button>
</Link>
        <p className="my-4 text-sm">
            <span>Already have an account?</span>
            <b onClick={toggle} className="cursor-pointer">Sign in here</b>
        </p>
    </div>
    </div>
);

export default SignUpForm;
