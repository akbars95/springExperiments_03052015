use myblog;
/*call SelectCaptcha(2);*/


/*version 1
SET @result = 0;
call CheckCaptcha('GY5dfdk43rv', @result);
SELECT @result;

call CheckCaptcha('GY5dfdk43rV', @result);
SELECT @result;


call CheckCaptcha('GY5dfdk43rv');
call CheckCaptcha('GY5dfdk43rV');
*/
call InsertMailMessage('mailMessage_mailToIn', 'mailMessage_mailFromIn', 'mailMessage_mailSubjectIn', 
'mailMessage_personNameIn', 'mailMessage_phoneNumberIn', 'mailMessage_mailTextIn', '23.06.2015 14:22:00', 
'23.06.2015 14:22:09', 'mailMessage_errorOrExceptionIn');

select *
from mailmessage mm
where ;


select *
from mailmessage mm
where 1 = 1;