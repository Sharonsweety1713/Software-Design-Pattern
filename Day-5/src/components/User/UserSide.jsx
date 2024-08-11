import React from 'react'
import { Link, NavLink } from 'react-router-dom'

import { LayoutDashboard,NotepadText,MessageCircleQuestion ,LogOut,Headset } from 'lucide-react'
const UserSide = () => {
    const UserLinks=[
        {
            title:'Dashboard',
            link:'/user/dashboard',
            icon:LayoutDashboard
        },
        {
            title:'Get Policy',
            link:'/user/plan',
            icon:NotepadText
        },
        {
            title:'FAQs',
            link:'/user/faq',
            icon:MessageCircleQuestion 
        }
        
    ]
    
    
  return (
   
    <div className='fixed h-screen w-1/6 flex flex-col justify-between items-center  pt-10 border-r-2 'style={{ borderColor: '#57B894' }}>
            <div className=' w-full flex flex-col  items-center gap-4'>
                {
                   UserLinks.map((data, index) => (
                        <NavLink key={index} to={data.link} className='p-5 border-b-4 border-gray-500 hover:border-customGreen font-bold mt-2 w-full '>

                            <span className='flex flex-row items-center justify-start h-full w-full gap-2'>
                                {React.createElement(data.icon, { size: 20 })}
                                {data.title}
                            </span>
                        </NavLink>
                    ))
                }
            </div>
           
            <div className='h-1/6 flex flex-col gap-2 justify-start items-center p-5 border-b-4 border-gray-500 hover:border-customGreen font-bold mt-2 w-full'>
    <span className='flex flex-row items-center justify-start h-full w-full gap-2'>
    <Link to='/'>
        <LogOut size={20} />
        </Link>
        <Link to='/'>
        Logout
        </Link>
    </span>
</div>

        </div>
        
  )
}
export default UserSide
