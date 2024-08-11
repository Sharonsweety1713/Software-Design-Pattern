import React from 'react'
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Activity } from 'lucide-react'

import { ModeToggle } from '../mode-toggle'
 const UserTop = () => {
  return (
    <div className='h-[8vh] w-full flex justify-center items-center border-b-2 'style={{ borderColor: '#57B894' }}>
        <div className='w-[90%] flex items-center justify-end gap-4'>
        
{/* <div className="w-1/4 h-full text-primary font-bold flex justify-start items-center text-lg ml-24 "><Activity/> Vital Echo</div> */}
<div className="w-1/4 h-full text-primary font-bold flex text-lg"><Activity/> Vital Echo</div>
        <Avatar>
  <AvatarImage src="https://github.com/shadcn.png" />
  <AvatarFallback>CN</AvatarFallback>
</Avatar>
        <ModeToggle/>

        </div>
        </div>
  )
}
export default UserTop
