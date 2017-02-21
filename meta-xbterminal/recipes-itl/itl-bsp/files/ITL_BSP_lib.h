#ifndef _ITL_BSP_LIB_H_
#define _ITL_BSP_LIB_H_

#if defined (__cplusplus)
extern "C" {
#endif

//=============================================================================
// Return Codes
//=============================================================================

#include "ITL_BSP_Error.h"

//=============================================================================
// Definitions
//=============================================================================

// PAYOUT OPTIONS
#define CASH	1
#define BITCOIN	2

//=============================================================================
// Function Definitions
//=============================================================================
int16_t ITL_BSP_GetHWVersion(uint8_t *major, uint8_t *minor, uint8_t *modstate);
int16_t ITL_BSP_GetLibVersion(uint8_t *major, uint8_t *minor, uint8_t *build);
int16_t ITL_BSP_Init_Paysys(void);

int16_t ITL_BSP_BuzzerEnable(void);
int16_t ITL_BSP_PlayTone(uint16_t freqHz, uint16_t duration);

int16_t ITL_BSP_APMGetStatus(uint8_t *status);
int16_t ITL_BSP_APMSetStatus(uint8_t status);

int16_t ITL_BSP_MircoUpdate(char *filename, uint8_t force_update);

int16_t ITL_BSP_HopperccTalkInit(void);
int16_t ITL_BSP_GetPayoutOptions(uint8_t *options);
int16_t ITL_BSP_GetPayoutStatus(void);
int16_t ITL_BSP_GetPayout(uint16_t *payout);
int16_t ITL_BSP_AddCredit(uint32_t credit);
int16_t ITL_BSP_PayoutCash( uint16_t amount );

int16_t ITL_BSP_SetLED(uint8_t);
int16_t ITL_BSP_STM32_RST(uint8_t);
int16_t ITL_BSP_STM32_BSL(uint8_t);
int16_t ITL_BSP_BL_EN(uint8_t);
int16_t ITL_BSP_DISP_ON(uint8_t);
int16_t ITL_BSP_SD1_OC(void);
int16_t ITL_BSP_ENET_RST(uint8_t);

int16_t ITL_BSP_WriteNDEF(char *);
int16_t ITL_BSP_ReadNDEF(char *);
int16_t ITL_BSP_EraseNDEF(void);

int16_t ITL_BSP_GetFram(void);

#if defined (__cplusplus)
}
#endif

#endif // _ITL_BSP_LIB_H_
