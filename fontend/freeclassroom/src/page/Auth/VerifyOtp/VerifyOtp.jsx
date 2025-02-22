import { useState, useRef } from "react";
import "./VerifyOtp.scss";
// import "../../../../node_modules/react-otp-input/example/src/index.css"
import OtpInput from 'react-verify-otp';
import '../../../../node_modules/react-verify-otp/dist/style.css'


const VerifyOTP = () => {

    const otpRef = useRef(null);
    const [otp, setOtp] = useState('');

    const handleChangeOtp = (otp) => {
        setOtp(otp)
    };
    

    return <div className="verify-otp-container row">

        <div className="col align-self-center">

            <div className="card text-center form-otp hover-shadow">
                <div className="card-header">VERIFY OTP</div>
                <i class="fa-solid fa-shield-halved"></i>
                <div className="card-body">
                    <h5 className="card-title">Enter the 4-digit verification code that was sent to your phone number</h5>


                    <div className="verify-otp-input">
                    <OtpInput
                        ref={otpRef}
                        otpValue={otp}
                        onChange={handleChangeOtp}
                        separator={'♦'}
                    />
                    </div>

                    <a href="#" className="btn btn-primary" data-mdb-ripple-init>
                        <i class="fa-solid fa-spinner loaderIcon" style={{marginRight:"10px"}}> </i> 
                        Verify OTP</a>
                    <p className="card-text">Didn't receive code ? <span className="high-ligt-text"> Resend here</span></p>
                </div>
                <div className="card-footer text-muted">2 days ago</div>
            </div>


        </div>
    
    </div>
}

export default VerifyOTP