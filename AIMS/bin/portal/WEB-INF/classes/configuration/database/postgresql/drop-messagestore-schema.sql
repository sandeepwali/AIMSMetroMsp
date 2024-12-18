----------------------------------------------
-- AIMS Message Queue Channel Message Store --
----------------------------------------------
DROP INDEX AIMS_MESSAGE_QUEUE_CHANNEL_MSG_DATE_IDX;
DROP INDEX AIMS_MESSAGE_QUEUE_CHANNEL_MSG_PRIORITY_IDX;
DROP TABLE AIMS_MESSAGE_QUEUE_CHANNEL_MESSAGE;
DROP SEQUENCE AIMS_MESSAGE_QUEUE_MESSAGE_SEQ;

-----------------------------------------------
-- AIMS Contract Queue Channel Message Store --
-----------------------------------------------
DROP INDEX AIMS_CONTRACT_QUEUE_CHANNEL_MSG_DATE_IDX;
DROP INDEX AIMS_CONTRACT_QUEUE_CHANNEL_MSG_PRIORITY_IDX;
DROP TABLE AIMS_CONTRACT_QUEUE_CHANNEL_MESSAGE;
DROP SEQUENCE AIMS_CONTRACT_QUEUE_MESSAGE_SEQ;