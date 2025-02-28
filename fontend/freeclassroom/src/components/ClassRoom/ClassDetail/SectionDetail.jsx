import { CiTimer } from "react-icons/ci";
import { LOCAL_HOST } from "../../../page/Class/ClassList";

const SectionDetail = ({post}) => {
    return (
        <div className="card section p-3">
            <div className="card-body">
                <div className="d-flex align-items-center">
                    
                    <div className="flex-shrink-0 me-3 start-0">
                        <img 
                            src={`${LOCAL_HOST}/files/image/${post?.postIcon}`}
                            alt="Icon"
                            className="rounded-circle"
                            style={{ width: "40px", height: "40px" }}
                        />
                    </div>

                    <div className="flex-grow-1 text-start content-text-section">
                        <p class="lead fw-normal mb-2">{post?.title}</p>
                        <p><span class="text-muted">Notice: </span>{post?.content} 
                        <br/><span class="text-muted"><CiTimer />&nbsp;Create Date: </span>{post?.createDate}</p>
                    </div>


                    <div className="flex-shrink-0 end-0">
                        <button className="btn btn-primary">Mark as done</button>
                    </div>

                </div>
            </div>
        </div>
    );
};
export default SectionDetail;
