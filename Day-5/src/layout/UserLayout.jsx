import UserSide from '@/components/User/UserSide';
import UserTop from '@/components/User/UserTop';
import React from 'react';
import { Outlet } from 'react-router-dom';

const UserLayout = () => {
  return (
    <div className='h-screen w-screen flex overflow-hidden'>
      <UserSide />
      <div className='flex flex-col w-5/6 ml-[16.666%]'>
        <UserTop />
        <div className='h-[92vh] overflow-y-auto'>
          <Outlet />
        </div>
      </div>
    </div>
  );
}

export default UserLayout;