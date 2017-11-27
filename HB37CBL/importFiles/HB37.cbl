        IDENTIFICATION DIVISION.
        PROGRAM-ID. HB37
        ENVIRONMENT DIVISION.    
        CONFIGURATION SECTION.                                                                                     
        DATA DIVISION. 
      * 
      * HB37 HEALTH CHECK
      * VERSION 1a
      * OCT 2006
      *
        LINKAGE SECTION.
      *    HB37 A   - Health check for VRU – PING Option
      *    HB37 B   - HOST Health check for VRU – DB Option 
                                               
      *****************************************************************
      * TELEPHONE BANKING HEALTH CHECK REQUEST (VRS TO IMS)       
      *****************************************************************
        01 HB-HCHKREQ.
          05 IMSLL                       PIC S9(3) COMP.
          05 IMSZZ                       PIC S9(3) COMP.  
          05 HBHDR-REQ.                                              
            07 TRCDNAME                  PIC X(8).  
            07 TRMLIDNT                  PIC X(10).  
            07 PORTIDNF                  PIC 9(5).                                         

      *****************************************************************
      * TELEPHONE BANKING HEALTH CHECK REPLY (IMS TO VRS)         
      *****************************************************************
        01 HB-HCHKRPY.
          05 IMSLL                       PIC S9(3) COMP.
          05 IMSZZ                       PIC S9(3) COMP.  
          05 HBHDR-RPY.
            07 TRCDNAME                  PIC X(8).                                            
            07 TRMLIDNT                  PIC X(10).
            07 PORTIDNF                  PIC 9(5).                                           
            07 STUS                      PIC X(2).            
          05 ERORMSGE.                                                    
            07 MSGENUMB                  PIC X(5).  
