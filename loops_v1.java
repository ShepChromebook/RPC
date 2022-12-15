public class loops_v1 {
   public static void main(String[] arsg) {
      /*
!!!!!!!!!!!!!!!!!!!!!!
\\!!!!!!!!!!!!!!!!!!//
\\\\!!!!!!!!!!!!!!////
\\\\\\!!!!!!!!!!//////
\\\\\\\\!!!!!!////////
\\\\\\\\\\!!//////////
      */
      for (int i=0; i<6; i++) { //6 rows
         for (int j=0; j<6; j++) { //6 collumns
            if (j >= 0+i)
               System.out.print("!!");
            else
               System.out.print("\\\\");
         }
         for (int j=4; j>=0; j--) { //5 collumns
            if (j >= 0+i)
               System.out.print("!!");
            else
               System.out.print("//");
         }
         System.out.println();
      }
/*
                     o  ****** *
                    /|\ *      *
                    / \ *      *
                 o  ******     * 
                /|\ *          *
                / \ *          *
            o  ******          *
           /|\ *               *
           / \ *               *
       o  ******               *
      /|\ *                    *
      / \ *                    *
 o  ******                     *
/|\ *                          *
/ \ *                          *
********************************
*/
      {"accessibility":{"captions":{"soda_registered_language_packs":["en-US"],"soda_scheduled_deletion_time":"0"}},"browser":{"enabled_labs_experiments":["enable-hardware-secure-decryption@1","password-import@1"],"last_whats_new_version":100,"shortcut_migration_version":"97.0.4692.71"},"chrome_labs_new_badge_dict":{"enable-lens-region-search":19026,"side-panel":19026,"webui-tab-strip":19026},"data_use_measurement":{"data_used":{"services":{"background":{},"foreground":{}},"user":{"background":{},"foreground":{}}}},"dns_over_https":{"mode":"automatic"},"hardware_acceleration_mode_previous":true,"invalidation":{"per_sender_topics_to_handler":{}},"legacy":{"profile":{"name":{"migrated":true}}},"os_crypt":{"encrypted_key":"RFBBUEkBAAAA0Iyd3wEV0RGMegDAT8KX6wEAAADPt08P01USQqnblD3zTFLhAAAAAAIAAAAAABBmAAAAAQAAIAAAAAegzfW1qMttJ3oU/JrVkL4t85bjp4d3ajYlWxAHL+C1AAAAAA6AAAAAAgAAIAAAABbuKh26gyUyUgk6+dvKsyxUsrLHOcDI5NfHPBlI/+SKMAAAAChj/mUUoco4iSVni5Z7V0lwqfehjTFgh2GvPtw7bDARpPm6U2SGldO8xg4q5NsEuUAAAABHIfOEYEwSJdbD/KZceiEyO5X5LYEwi1eEeHGe+AQFljqRAEJtMG1J0vIzdhKh7myXaVzeF9XeA5nQdvgV6Ogf"},"plugins":{"metadata":{"adobe-flash-player":{"displayurl":true,"group_name_matcher":"*Shockwave Flash*","help_url":"https://support.google.com/chrome/?p=plugin_flash","lang":"en-US","mime_types":["application/futuresplash","application/x-shockwave-flash"],"name":"Adobe Flash Player","url":"https://www.adobe.com/products/flashplayer/end-of-life.html","versions":[{"reference":"https://www.adobe.com/products/flashplayer/end-of-life.html","status":"requires_authorization","version":"32.0.0.466"}]},"chromium-pdf":{"group_name_matcher":"*Chromium PDF Viewer*","mime_types":[],"name":"Chromium PDF Viewer","versions":[{"comment":"Chromium PDF Viewer has no version information.","status":"fully_trusted","version":"0"}]},"chromium-pdf-plugin":{"group_name_matcher":"*Chromium PDF Plugin*","mime_types":[],"name":"Chromium PDF Plugin","versions":[{"comment":"Chromium PDF Plugin has no version information.","status":"fully_trusted","version":"0"}]},"google-chrome-pdf":{"group_name_matcher":"*Chrome PDF Viewer*","mime_types":[],"name":"Chrome PDF Viewer","versions":[{"comment":"Google Chrome PDF Viewer has no version information.","status":"fully_trusted","version":"0"}]},"google-chrome-pdf-plugin":{"group_name_matcher":"*Chrome PDF Plugin*","mime_types":[],"name":"Chrome PDF Plugin","versions":[{"comment":"Google Chrome PDF Plugin has no version information.","status":"fully_trusted","version":"0"}]},"x-version":62},"resource_cache_update":"1643858829.575999"},"policy":{"last_statistics_update":"13315533058346459"},"profile":{"info_cache":{"Default":{"active_time":1671082275.435733,"avatar_icon":"chrome://theme/IDR_PROFILE_AVATAR_26","background_apps":false,"force_signin_profile_locked":false,"gaia_given_name":"","gaia_id":"","gaia_name":"","hosted_domain":"","is_consented_primary_account":false,"is_ephemeral":false,"is_using_default_avatar":true,"is_using_default_name":true,"managed_user_id":"","metrics_bucket_index":1,"name":"Person 1","shortcut_name":"Person 1","user_name":""}},"last_active_profiles":["Default"],"last_used":"Default","metrics":{"next_bucket_index":2},"picker_shown":true,"profile_counts_reported":"13315533058346355"},"profile_network_context_service":{"http_cache_finch_experiment_groups":"None None None None"},"shutdown":{"num_processes":0,"num_processes_slow":0,"type":0},"subresource_filter":{"ruleset_version":{"checksum":1212134386,"content":"9.32.0","format":34}},"tab_stats":{"last_daily_sample":"13315538234863940","max_tabs_per_window":61,"total_tab_count_max":74,"window_count_max":3},"task_manager":{"column_visibility":{"IDS_TASK_MANAGER_CPU_COLUMN":true,"IDS_TASK_MANAGER_CPU_TIME_COLUMN":false,"IDS_TASK_MANAGER_GDI_HANDLES_COLUMN":false,"IDS_TASK_MANAGER_HARD_FAULTS_COLUMN":false,"IDS_TASK_MANAGER_IDLE_WAKEUPS_COLUMN":false,"IDS_TASK_MANAGER_JAVASCRIPT_MEMORY_ALLOCATED_COLUMN":false,"IDS_TASK_MANAGER_KEEPALIVE_COUNT_COLUMN":false,"IDS_TASK_MANAGER_MEM_FOOTPRINT_COLUMN":true,"IDS_TASK_MANAGER_NET_COLUMN":true,"IDS_TASK_MANAGER_PROCESS_ID_COLUMN":true,"IDS_TASK_MANAGER_PROCESS_PRIORITY_COLUMN":false,"IDS_TASK_MANAGER_PROFILE_NAME_COLUMN":false,"IDS_TASK_MANAGER_SQLITE_MEMORY_USED_COLUMN":false,"IDS_TASK_MANAGER_START_TIME_COLUMN":false,"IDS_TASK_MANAGER_TASK_COLUMN":true,"IDS_TASK_MANAGER_USER_HANDLES_COLUMN":false,"IDS_TASK_MANAGER_VIDEO_MEMORY_COLUMN":false,"IDS_TASK_MANAGER_WEBCORE_CSS_CACHE_COLUMN":false,"IDS_TASK_MANAGER_WEBCORE_IMAGE_CACHE_COLUMN":false,"IDS_TASK_MANAGER_WEBCORE_SCRIPTS_CACHE_COLUMN":false,"sort_column_id":""},"window_placement":{"bottom":588,"left":440,"maximized":false,"right":1096,"top":228,"work_area_bottom":1392,"work_area_left":0,"work_area_right":3440,"work_area_top":0}},"ukm":{"persisted_logs":[]},"uninstall_metrics":{"installation_date2":"1643858340"},"updateclientdata":{"apps":{"cmahhnpholdijhjokonmfdjbfmklppij":{"cohort":"1:wr3:","cohortname":"Auto","dlrc":5511,"fp":"1.b4ddbdce4f8d5c080328aa34c19cb533f2eedec580b5d97dc14f74935e4756b7","pf":"210ff2fe-e9d6-485c-868c-04e538f92d21","pv":"1.0.6"},"dhlpobdgcjafebgbbhjdnapejmpkgiie":{"cohort":"1:z9x:","cohortname":"Auto","dlrc":5511,"pf":"8c994bdc-911a-479d-8dcd-6608e115f0a1"},"eeigpngbgcognadeebkilcpcaedhellh":{"cohort":"1:w59:","cohortname":"Auto","dlrc":5511,"pf":"b4261d5c-3f94-4b5d-8c3b-40d2b0f81b62"},"efniojlnjndmcbiieegkicadnoecjjef":{"cohort":"1:zkl:","cohortname":"Auto","dlrc":5511,"pf":"0922cd42-af94-4d53-ab95-1553d865adab"},"gcmjkmgdlgnkkcocmoeiminaijmmjnii":{"cohort":"1:bm1:11vf@0.01","cohortname":"M54AndUp","dlrc":5511,"fp":"1.dbbba5869c1d8946e5e23215c0404619fe82793d60eb89489b345ef55023e077","pf":"53057496-00da-409d-b599-2d9b3a57766e","pv":"9.32.0"},"ggkkehgbnfjpeggfpleeakpidbkibbmn":{"cohort":"1:ttl:","cohortname":"Rest","dlrc":5511,"pf":"2a97242f-b35d-4498-8682-9394978939f9"},"giekcmmlnklenlaomppkphknjmnnpneh":{"cohort":"1:j5l:","cohortname":"Auto","dlrc":5511,"pf":"63b3b676-8a48-4e5a-8c38-ad398b56308c"},"gonpemdgkjcecdgbnaabipppbmgfggbe":{"cohort":"1:z1x:","cohortname":"General release","dlrc":5511,"fp":"1.9f3dda168dccf79be5e9593992108a31d2f83c8fe5f63bfc0a1b725f2a3ca47a","pf":"9b2f50b8-f73f-4b5e-ba92-889d3c3d9b3e","pv":"2021.6.24.0"},"hfnkpimlhhgieaddgfemjhofmfblmnib":{"cohort":"1:jcl:","cohortname":"Auto","dlrc":5511,"pf":"266fab4f-e120-48dc-9cbc-e8fb7074a64c"},"hnimpnehoodheedghdeeijklkeaacbdc":{"cohort":"1::","cohortname":"","dlrc":5511,"fp":"1.6f6bc93dcd62dc251850d2ff458fda96083ceb7fbe8eeb11248b8485ef2aea23","pf":"2343ff4d-7268-475a-b8ac-8f62a6e187ac","pv":"0.57.44.2492"},"imefjhfbkmcmebodilednhmaccmincoa":{"cohort":"1:11cr:","cohortname":"v27.4","dlrc":5511,"pf":"77fe3264-4dcd-4dc7-9ea4-fbcd3eee8579"},"jamhcnnkihinmdlkakkaopbjbbcngflc":{"cohort":"1:wvr:","cohortname":"Auto","dlrc":5511,"pf":"4dacd1e7-df2f-495f-b04f-e2159c7bbe65"},"jflookgnkcckhobaglndicnbbgbonegd":{"cohort":"1:s7x:","cohortname":"Auto","dlrc":5511,"pf":"f1b24cd5-383b-4cb1-b01b-b383da102fab"},"khaoiebndkojlmppeemjhbpbandiljpe":{"cohort":"1:cux:","cohortname":"Auto","dlrc":5511,"pf":"ae4874ef-19d3-4ec3-80de-aa0c479a5055"},"kiabhabjdbkjdpjbpigfodbdjmbglcoo":{"cohort":"1:v3l:","cohortname":"Auto","dlrc":5511,"pf":"ad8c26dd-61c9-400b-b045-8c5fd048d4d8"},"laoigpblnllgcgjnjnllmfolckpjlhki":{"cohort":"1:10zr:","cohortname":"Auto","dlrc":5511,"pf":"3a62227b-2661-4a41-b4ac-577318735fc5"},"llkgjffcdpffmhiakmfcdcblohccpfmo":{"cohort":"1::","cohortname":"","dlrc":5511,"pf":"56a81ab1-91ca-46d0-adb2-4c8a2835958f"},"lmelglejhemejginpboagddgdfbepgmp":{"cohort":"1:lwl:","cohortname":"Auto","dlrc":5511,"fp":"1.505f86d2b495a009fe715fcddf55d6af35f5189b4a8b093c7933de0e18595e78","pf":"51a2bc0a-95c0-4314-baf5-ffb4653e94f0","pv":"316"},"obedbbhbpmojnkanicioggnmelmoomoc":{"cohort":"1:s6f:","cohortname":"Auto","dlrc":5511,"fp":"1.fd5f399515d933a52ffc16ea7a38364ed4b7575429e1a908f13e27b017ab8e74","pf":"2183bc26-cd00-4980-a084-9d8bf3e692d2","pv":"20220124.424838780"},"ojhpjlocmbogdgmfpkhlaaeamibhnphh":{"cohort":"1:w0x:","cohortname":"Auto","dlrc":5511,"pf":"65e3e7ab-681b-4248-8a16-0cb41f67a76a"},"pdafiollngonhoadbmdoemagnfpdphbe":{"cohort":"1:vz3:","cohortname":"Auto","dlrc":5511,"pf":"273efc44-d53d-4d99-8771-983cc4a7e873"}}},"user_experience_metrics":{"low_entropy_source3":5800,"machine_id":9236519,"pseudo_low_entropy_source":6764,"session_id":281,"stability":{"browser_last_live_timestamp":"13315557135805275","child_process_crash_count":171,"crash_count":21,"exited_cleanly":false,"extension_renderer_crash_count":0,"extension_renderer_failed_launch_count":0,"extension_renderer_launch_count":38767,"gpu_crash_count":0,"incomplete_session_end_count":108,"launch_count":280,"page_load_count":425535,"plugin_stats2":[{"crashes":1,"instances":0,"launches":220,"loading_errors":0,"name":"Chromium PDF Plugin"}],"renderer_crash_count":32,"renderer_failed_launch_count":0,"renderer_hang_count":446,"renderer_launch_count":77065,"session_end_completed":true,"stats_buildtime":"1638680400","stats_version":"97.0.4692.71-64-devel","system_crash_count":9}},"variations_crash_streak":21,"was":{"restarted":false}}
/*
     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
+=*=*=*=*=*=*+
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
+=*=*=*=*=*=*+
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
+=*=*=*=*=*=*+
    /**\
   //**\\
  ///**\\\
 ////**\\\\
/////**\\\\\




            ||
            ||
            ||
            ||
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
\_/\/\/\/\/\/\/\/\/\/\/\_/
  \_/\/\/\/\/\/\/\/\/\_/
    \_/\/\/\/\/\/\/\_/
      \_/\/\/\/\/\_/
            ||
            ||
            ||
            ||
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
*/
      for (int i=0;) {
         for 
      }
   }
}
