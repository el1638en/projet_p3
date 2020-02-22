package com.openclassrooms.bibliotheque.models;

import com.openclassrooms.bibliotheque.ws.MemberWs;
import com.openclassrooms.bibliotheque.ws.WorkWs;

public class BorrowBook {

    private WorkWs workWs;

    private MemberWs memberWs;

    public WorkWs getWorkWs() { return workWs; }

    public void setWorkWs(WorkWs workWs) {
        this.workWs = workWs;
    }

    public MemberWs getMemberWs() {
        return memberWs;
    }

    public void setMemberWs(MemberWs memberWs) {
        this.memberWs = memberWs;
    }
}
