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
            title:'Get Plan',
            link:'/user/plan',
            icon:NotepadText
        },
        {
            title:'FAQs',
            link:'/user/faq',
            icon:MessageCircleQuestion 
        },
        {
            title:'Help',
            link:'/user/help',
            icon:Headset
        }
    ]
    
    
  return (
   
    <div className='h-screen w-1/6 flex justify-center items-center flex-col pt-10 border-r-2 'style={{ borderColor: '#57B894' }}>
            <div className='h-5/6 w-full flex flex-col justify-start items-center gap-4'>
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
        <LogOut size={20} />
        Logout
    </span>
</div>

        </div>
        
  )
}
export default UserSide
