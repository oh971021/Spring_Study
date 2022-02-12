package com.js.pj.sns;

import java.util.List;

public interface SNSMapper {

	int getMsgCount(SNSSelector sSel);

	List<SNSMsg> getMsg(SNSSelector search);

	List<SNSReply> getReply(SNSMsg snsMsg);

}
