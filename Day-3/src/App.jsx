
import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './pages/Shared/Home'
import Login from './pages/Shared/Login'
import Register from './pages/Shared/Register'
import UserLayout from './layout/UserLayout'
import GetPlans from './pages/User/GetPlans'
import Faq from './pages/User/Faq'
import ExpertHelp from './pages/User/ExpertHelp'
import AdminLayout from './layout/AdminLayout'
import AdminDashboard from './pages/Admin/AdminDashboard'
import UserDashboard from './pages/User/UserDashboard'
import NotFound from './pages/Shared/NotFound'
import HomeLayout from './layout/HomeLayout'
import AdminSignIn from './pages/Shared/AdminSignIn'
import Users  from './pages/Admin/Users'
import Claims from './pages/Admin/Claims'


const App = () => {
    return (
        <>
        
            <BrowserRouter>
                <Routes>
                    <Route element={<HomeLayout />}>
                        <Route path='/' element={<Home />} />
                        <Route path='/login' element={<Login />} />
                        <Route path='/register' element={<Register />} />
                        <Route path='/adminlogin' element={<AdminSignIn />} />
                    </Route>
                  
                    <Route element={<UserLayout />}>
                        <Route path='/user/dashboard' element={<UserDashboard />} />
                        <Route path='/user/plan' element={<GetPlans/>} />
                        <Route path='/user/faq' element={<Faq />} />
                        <Route path='/user/help' element={<ExpertHelp/>} />
                    </Route>
                    
                    <Route element={<AdminLayout />}>
                        <Route path='/admin/dashboard' element={<AdminDashboard />} />
                        <Route path='/admin/users' element={<Users />} />
                        <Route path='/admin/claims' element={<Claims />} />
                    </Route>

                    <Route path='*' element={<NotFound />} />
                </Routes>
            </BrowserRouter>


        </>
    )
}

export default App