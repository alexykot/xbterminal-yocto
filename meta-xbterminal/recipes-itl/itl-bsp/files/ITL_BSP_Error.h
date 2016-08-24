#ifndef _ITL_BSP_ERROR_H_
#define _ITL_BSP_ERROR_H_

#if defined (__cplusplus)
extern "C" {
#endif

//=============================================================================
// Return & Error Codes
//=============================================================================
enum
{
	// GENERIC CODES
	ITL_BSP_OK		= 0,
	// PAYOUT CODES
	ITL_BSP_PAYOUT_IDLE = 0x10,
	ITL_BSP_PAYOUT_PENDING = 0x11,
	ITL_BSP_PAYOUT_COMPLETE = 0x12,
	
	// APM STATUS CODES
	ITL_BSP_APM_IDLE = 0x20,
	ITL_BSP_APM_ACTIVE = 0x21,
	ITL_BSP_APM_OUTOFSERVICE = 0x22,
	
	
	// Error Codes
	ITL_BSP_FAIL	= -1,
	ITL_BSP_SPI_FAIL = -2,
	ITL_BSP_MSG_FAIL = -3,
};


#if defined (__cplusplus)
}
#endif

#endif // _ITL_BSP_LIB_H_
